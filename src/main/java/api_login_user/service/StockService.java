package api_login_user.service;

import api_login_user.model.AtualizarItemStock;
import api_login_user.model.StockModel;
import api_login_user.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public StockModel register(StockModel stock) {
        StockModel stockExisty = stockRepository.findByNameItem(stock.getNameItem());
        if(stockExisty.getNameItem() != null && !stockExisty.getNameItem().isEmpty()) {
            return stockRepository.save(stock);

        } else {
            throw new RuntimeException("O estoque já existe!");
        }
    }

    public List<StockModel> findAll() {
        return stockRepository.findAll();
    }

    public StockModel updateStock(AtualizarItemStock req) {
        StockModel stock = stockRepository.findByNameItem(req.getOldName());

        if(req.getNewName() != null && !req.getNewName().isEmpty()) {
            stock.setNameItem(req.getNewName());
        }

        if(req.getQuantidade() != null) {
            stock.setQuantidadeItem(req.getQuantidade());
        }
        return stockRepository.save(stock);
    }

    public boolean deleteByName(String nameItem) {
        StockModel existingStock = stockRepository.findByNameItem(nameItem);
        return (existingStock != null) ? deleteAndReturnTrue(existingStock) : false;
    }

    private boolean deleteAndReturnTrue(StockModel stock) {
        stockRepository.delete(stock);
        return true;
    }
}
