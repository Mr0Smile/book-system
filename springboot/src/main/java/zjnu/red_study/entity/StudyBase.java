package zjnu.red_study.entity;

public class StudyBase {

    private Integer id;

    /**
     * 研学基地名字
     */
    private String studyBaseName;

    /**
     * 研学基地介绍
     */
    private String descr;

    /**
     * 文章ID
     */
    private Integer articleId;

    /**
     * 专栏ID
     */
    private Integer specialColumnId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudyBaseName() {
        return studyBaseName;
    }

    public void setStudyBaseName(String studyBaseName) {
        this.studyBaseName = studyBaseName;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getSpecialColumnId() {
        return specialColumnId;
    }

    public void setSpecialColumnId(Integer specialColumnId) {
        this.specialColumnId = specialColumnId;
    }

    @Override
    public String toString() {
        return "StudyBase{" + "id=" + id + ", studyBaseName='" + studyBaseName + '\'' + ", descr='" + descr + '\''
                + ", articleId=" + articleId + ", specialColumnId=" + specialColumnId + '}';
    }
}
