package models;

import java.util.Date;


/**
 * @author hebod
 * @version 1.0
 * @created 14-nov-2022 9:08:52 PM
 */
public class Output {

	private int idOutput;
	private String outputDate;
	private double outputPrice;
	private int outputQuantity;
	private Product m_Product;
	private User m_User;

	public Output(){

	}

    public Output(int idOutput, String outputDate, double outputPrice, int outputQuantity, Product m_Product, User m_User) {
        this.idOutput = idOutput;
        this.outputDate = outputDate;
        this.outputPrice = outputPrice;
        this.outputQuantity = outputQuantity;
        this.m_Product = m_Product;
        this.m_User = m_User;
    }

    public int getIdOutput() {
        return idOutput;
    }

    public void setIdOutput(int idOutput) {
        this.idOutput = idOutput;
    }

    public String getOutputDate() {
        return outputDate;
    }

    public void setOutputDate(String outputDate) {
        this.outputDate = outputDate;
    }

    public double getOutputPrice() {
        return outputPrice;
    }

    public void setOutputPrice(double outputPrice) {
        this.outputPrice = outputPrice;
    }

    public int getOutputQuantity() {
        return outputQuantity;
    }

    public void setOutputQuantity(int outputQuantity) {
        this.outputQuantity = outputQuantity;
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
        return "Output{" + "idOutput=" + idOutput + ", outputDate=" + outputDate + ", outputPrice=" + outputPrice + ", outputQuantity=" + outputQuantity + ", m_Product=" + m_Product + ", m_User=" + m_User + '}';
    }
    
}//end Output