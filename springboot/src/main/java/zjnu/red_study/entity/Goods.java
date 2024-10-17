package zjnu.red_study.entity;

public class Goods {
    /**
     * 商品id
     */
    private Integer id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品图片
     */
    private String img;
     /**
     * 商品描述
     */
    private String descr;
    /**
     * 商品特色
     */
    private String specials;
    /**
     * 商品价格
     */
    private Double price;
    /**
     * 商品折扣
     */
    private Double discount;
    /**
     * 商品单位
     */
    private String unit;
    /**
     * 商品库存
     */
    private Integer stock;
    /**
     * 商品分类id
     */
    private Integer category_id;
    /**
     * 商品分类名称
     */
    private String category_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getSpecials() {
        return specials;
    }

    public void setSpecials(String specials) {
        this.specials = specials;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", descr='" + descr + '\'' +
                ", specials='" + specials + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", unit='" + unit + '\'' +
                ", stock=" + stock +
                ", category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}
