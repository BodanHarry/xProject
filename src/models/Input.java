package models;



/**
 * @author hebod
 * @version 1.0
 * @created 14-nov-2022 9:08:51 PM
 */
public class Input {

	private int idInput;
	private String inputDate;
	private double inputPrice;
	private int inputQuantity;
	private Product m_Product;
	private User m_User;

	public Input(){

	}

    public Input(int idInput, String inputDate, double inputPrice, int inputQuantity, Product m_Product, User m_User) {
        this.idInput = idInput;
        this.inputDate = inputDate;
        this.inputPrice = inputPrice;
        this.inputQuantity = inputQuantity;
        this.m_Product = m_Product;
        this.m_User = m_User;
    }

    public int getIdInput() {
        return idInput;
    }

    public void setIdInput(int idInput) {
        this.idInput = idInput;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public double getInputPrice() {
        return inputPrice;
    }

    public void setInputPrice(double inputPrice) {
        this.inputPrice = inputPrice;
    }

    public int getInputQuantity() {
        return inputQuantity;
    }

    public void setInputQuantity(int inputQuantity) {
        this.inputQuantity = inputQuantity;
    }

    public Product getM_Product() {
        return m_Product;
    }

    public void setM_Product(Product m_Product) {
        this.m_Product = m_Product;
    }

    public User getM_User() {
        return m_User;
    }

    public void setM_User(User m_User) {
        this.m_User = m_User;
    }

    @Override
    public String toString() {
        return "Input{" + "idInput=" + idInput + ", inputDate=" + inputDate + ", inputPrice=" + inputPrice + ", inputQuantity=" + inputQuantity + ", m_Product=" + m_Product + ", m_User=" + m_User + '}';
    }
        
        
}//end Input