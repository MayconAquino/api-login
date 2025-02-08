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

    public ResponseEntity<?> register(StockModel stock) {
        StockModel stockExists = stockRepository.findByNameItem(stock.getNameItem());
        if(stockExists == null) {
            StockModel stockSalvo = stockRepository.save(stock);
            return ResponseEntity.ok(stockSalvo);
        }
        return  ResponseEntity.badRequest().body("Item ja existe");
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
