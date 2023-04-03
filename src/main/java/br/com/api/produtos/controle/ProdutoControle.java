package br.com.api.produtos.controle;

import br.com.api.produtos.model.ProdutoModelo;
import br.com.api.produtos.model.RespostaModelo;
import br.com.api.produtos.servico.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class ProdutoControle {

    @Autowired
    private ProdutoServico ps;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoModelo pm){
        return ps.cadastrarAlterar(pm, "cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody ProdutoModelo pm){
        return ps.cadastrarAlterar(pm, "alterar");
    }

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long codigo){
        return ps.remover(codigo);
    }


    @GetMapping("/listar")
    public Iterable<ProdutoModelo> listar(){
        return ps.listar();
    }

    @GetMapping("/")
    public String rota() {
        return "API de produtos funcionando!";
    }
}
