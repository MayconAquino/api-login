package api_login_user.Dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDto {

    private String nameItem;

    private Integer quantidadeItem;

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public Integer getQuantidadeItem() {
        return quantidadeItem;
    }

    public void setQuantidadeItem(Integer quantidadeItem) {
        this.quantidadeItem = quantidadeItem;
    }
}
