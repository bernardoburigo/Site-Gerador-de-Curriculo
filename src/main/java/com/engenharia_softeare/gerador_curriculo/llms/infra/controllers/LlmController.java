package com.engenharia_softeare.gerador_curriculo.llms.infra.controllers;

import com.engenharia_softeare.gerador_curriculo.llms.applications.usecases.GerarCurriculoUseCase;
import com.engenharia_softeare.gerador_curriculo.llms.applications.usecases.GerarPerguntasUseCase;
import com.engenharia_softeare.gerador_curriculo.llms.infra.controllers.dto.request.AreaAtuacaoRequestDTO;
import com.engenharia_softeare.gerador_curriculo.llms.infra.controllers.dto.request.GerarCurriculoRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/llm")
public class LlmController {

    private final GerarPerguntasUseCase gerarPerguntasUseCase;
    private final GerarCurriculoUseCase gerarCurriculoUseCase;

    public LlmController(GerarPerguntasUseCase gerarPerguntasUseCase, GerarCurriculoUseCase gerarCurriculoUseCase) {
        this.gerarPerguntasUseCase = gerarPerguntasUseCase;
        this.gerarCurriculoUseCase = gerarCurriculoUseCase;
    }

    @PostMapping("/gerar-perguntas")
    public ResponseEntity<String> enviarPerguntas(@RequestBody AreaAtuacaoRequestDTO dto) {
        return ResponseEntity.ok(gerarPerguntasUseCase.gerar(dto));
    }

    @PostMapping("/gerar-curriculo")
    public ResponseEntity<String> gerarCurriculo(@RequestBody GerarCurriculoRequestDTO dto) {
        return ResponseEntity.ok(gerarCurriculoUseCase.gerar(dto));
    }
}
