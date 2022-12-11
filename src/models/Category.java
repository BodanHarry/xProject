package models;


/**
 * @author hebod
 * @version 1.0
 * @created 14-nov-2022 9:08:51 PM
 */
public class Category {

	private int idCategory;
	private String productDescription;
	private String productType;
	private String productSize;

	public Category(){

	}

    public Category(int idCategory, String productDescription, String productType, String productSize) {
        this.idCategory = idCategory;
        this.productDescription = productDescription;
        this.productType = productType;
        this.productSize = productSize;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    @Override
    public String toString() {
        return "Category{" + "idCategory=" + idCategory + ", productDescription=" + productDescription + ", productType=" + productType + ", productSize=" + productSize + '}';
    }
    
    
}//end Category