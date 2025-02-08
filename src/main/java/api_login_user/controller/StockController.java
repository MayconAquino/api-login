package api_login_user.controller;

import api_login_user.Dtos.StockDto;
import api_login_user.model.AtualizarItemStock;
import api_login_user.model.StockModel;
import api_login_user.service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody StockDto request) {
            StockModel stock = new StockModel();
            stock.setNameItem(request.getNameItem());
            stock.setQuantidadeItem(request.getQuantidadeItem());
            return stockService.register(stock);
    }

    @PutMapping("/editar")
    public ResponseEntity<StockModel> updateStock(@RequestBody AtualizarItemStock req) {
        StockModel updatedStock = stockService.updateStock(req);
        return ResponseEntity.ok(updatedStock);
    }

    @DeleteMapping("/deletar/{name}")
    public ResponseEntity<String> deleteStock(@PathVariable String name) {
        return stockService.deleteByName(name)
                ? ResponseEntity.ok("Item removido com sucesso!")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item não encontrado.");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<StockModel>> getAllStocks() {
        List<StockModel> stocks = stockService.findAll();
        return stocks.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(stocks);
    }

}
