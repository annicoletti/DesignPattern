
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author nicoletti
 */
public class OneTest implements Serializable {

    private static final long serialVersionUID = 2L;

    String fullName;

    Integer number;

    Boolean status;

    Double decimal;

    List<String> textList;

    String description;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getDecimal() {
        return decimal;
    }

    public void setDecimal(Double decimal) {
        this.decimal = decimal;
    }

    public List<String> getTextList() {
        return textList;
    }

    public void setTextList(List<String> textList) {
        this.textList = textList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "OneTest{" + "fullName=" + fullName + ", number=" + number + ", status=" + status + ", decimal=" + decimal + ", textList=" + textList + ", description=" + description + '}';
    }

}
