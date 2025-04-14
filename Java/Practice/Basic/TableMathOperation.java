import java.util.Scanner;
//TODO: Переписать на switch/case, проверять на заглавные буквы, вынести расчеты в отедльные функции
public class TableMathOperation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Выберите операцию(f,r,s,с): ");
		char operation = scanner.next().charAt(0);
		if(operation == 'f'){
			int f = 1;
			for (int i = 1; i < 11; i++) {
				f *= i;//Factorial of a number
				System.out.printf("%5d → %-4d",i,f);
				System.out.println();
			}
			scanner.close();
		}else if(operation == 'r'){        
			for (int i = 1; i <= 100; i++) {
					int square = i * i;//Root of a number
					System.out.printf("%4d → %-4d | ", square, i);
					
					if ((i + 1) % 4 == 0) {
							System.out.println();
					}
		}
			scanner.close();
		}else if(operation == 's'){
			for (int i = 0; i <= 100; i++) {
				int square = i * i;//Number square
				System.out.printf("%5d → %-4d | ", i, square);
				
				if ((i + 1) % 4 == 0) {
						System.out.println();
				}
			}
			scanner.close();
		}else if(operation == 'c'){
			for (int i = 0; i <= 100; i++) {
				int cube = i * i * i;//Number cube
				System.out.printf("%5d → %-4d | ", i, cube);
				
				if ((i + 1) % 4 == 0) {
						System.out.println();
				}
			}
			scanner.close();
		}else{
			System.out.println("Введена некорректная операция!");
			scanner.close();
		}
	}
}