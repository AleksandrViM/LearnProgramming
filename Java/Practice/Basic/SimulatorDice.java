import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SimulatorDice {
    private static final int MAX_ROLLS = 10_000;
    private static final int MAX_DICE = 6;
    private static final double MIN_PROBABILITY_PERCENT = 0.0001;
    private static final int MAX_PROBABILITY_ROLLS = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество бросков: ");
        try {
            int diceRollsCount = scanner.nextInt();
            int[] rolls = generateDiceRolls(diceRollsCount);
            System.out.println("Результаты бросков: " + Arrays.toString(rolls));

            double probability = calculateProbability(diceRollsCount);
            if (probability == 0) {
                if (diceRollsCount > MAX_PROBABILITY_ROLLS) {
                    System.err.println("Вероятность не рассчитывается для более чем " + MAX_PROBABILITY_ROLLS + " бросков!");
                } else {
                    System.err.println("Вероятность меньше " + MIN_PROBABILITY_PERCENT + "%!");
                }
            } else {
                System.out.printf("Вероятность выпадения: %.6f%%\n", probability);
            }
        } catch (InputMismatchException e) {
            System.err.println("Введены некорректные данные!");
        } catch (ArithmeticException e) {
            System.err.println("Введено слишком большое количество бросков!");
        } catch (IllegalArgumentException e) {
            System.err.println("Количество бросков должно быть положительным!");
        } catch (NoSuchElementException e) {
            System.err.println("Ввод был заблокирован!");
        } finally {
            scanner.close();
        }
    }

    static int[] generateDiceRolls(int diceRollsCount) {
        if (diceRollsCount <= 0) {
            throw new IllegalArgumentException("Количество бросков должно быть положительным!");
        }
        if (diceRollsCount >= MAX_ROLLS) {
            throw new ArithmeticException("Введено слишком большое количество бросков!");
        }

        int[] diceResults = new int[diceRollsCount];
        for (int i = 0; i < diceRollsCount; i++) {
            diceResults[i] = 1 + (int) (Math.random() * MAX_DICE);
        }
        return diceResults;
    }

    static double calculateProbability(int diceRollsCount) {
        if (diceRollsCount > MAX_PROBABILITY_ROLLS) {
            return 0;
        }

        double probability = Math.pow(1.0 / MAX_DICE, diceRollsCount) * 100;
        return probability < MIN_PROBABILITY_PERCENT ? 0 : probability;
    }
}