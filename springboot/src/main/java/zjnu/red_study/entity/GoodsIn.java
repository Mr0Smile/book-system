package zjnu.red_study.entity;

public class GoodsIn {
    /**
     * 进货ID
     */
    private Integer id;
    /**
     * 货物ID
     */
    private Integer goods_id;
    /**
     * 货物数量
     */
    private Integer num;
    /**
     * 进货渠道
     */
    private String channel;
    /**
     * 进货时间
     */
    private String date;
    /**
     * 注释
     */
    private String comment;
    /**
     * 货物名称
     */
    private String goods_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    @Override
    public String toString() {
        return "GoodsIn{" +
                "id=" + id +
                ", goods_id=" + goods_id +
                ", num=" + num +
                ", channel='" + channel + '\'' +
                ", date='" + date + '\'' +
                ", comment='" + comment + '\'' +
                ", goods_name='" + goods_name + '\'' +
                '}';
    }
}
