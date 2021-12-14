
public class TestCheckedException {

	public static void main(String[] args) {
		
		try {
			int amountAdder = CustomCheckedException.AmountAdder(1, 2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		CustomUnchekedException.AmountAdder1(1, 1);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

}
