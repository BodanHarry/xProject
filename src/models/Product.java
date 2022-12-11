package models;


/**
 * @author hebod
 * @version 1.0
 * @created 14-nov-2022 9:08:51 PM
 */
public class Product {

	private String productName;
	private String productColor;
	private int idProduct;
	private double productPrice;
	private Category m_Category;
        private int productQuantity;

	public Product(){

	}

    public Product(String productName, String productColor, int idProduct, double productPrice, Category m_Category, int productQuantity) {
        this.productName = productName;
        this.productColor = productColor;
        this.idProduct = idProduct;
        this.productPrice = productPrice;
        this.m_Category = m_Category;
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Category getM_Category() {
        return m_Category;
    }

    public void setM_Category(Category m_Category) {
        this.m_Category = m_Category;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
    @Override
    public String toString() {
        return "Product{" + "productName=" + productName + ", productColor=" + productColor + ", idProduct=" + idProduct + ", productPrice=" + productPrice + ", m_Category=" + m_Category + ", productQuantity=" + productQuantity + '}';
    }

}//end Product