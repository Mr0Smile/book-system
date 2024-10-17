package zjnu.red_study.entity;

/**
 * 分类实体类
 */

public class Category {
    /**
     * 分类ID
     */
    private Integer id;
    /**
     * 分类名称
     */
    private String category;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
