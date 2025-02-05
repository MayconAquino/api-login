package api_login_user.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "stock_model")
@AllArgsConstructor
@NoArgsConstructor
public class StockModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nameItem;

    @Column
    private Integer quantidadeItem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
