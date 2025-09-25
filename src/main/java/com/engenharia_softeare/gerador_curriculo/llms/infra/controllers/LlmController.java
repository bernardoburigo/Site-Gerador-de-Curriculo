package com.engenharia_softeare.gerador_curriculo.llms.infra.controllers;

import com.engenharia_softeare.gerador_curriculo.llms.applications.usecases.EnviarAreaAtuacaoUseCase;
import com.engenharia_softeare.gerador_curriculo.llms.infra.controllers.dto.request.AreaAtuacaoRequestDTO;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/llm")
public class LlmController {

    private final EnviarAreaAtuacaoUseCase enviarAreaAtuacaoUseCase;

    public LlmController(EnviarAreaAtuacaoUseCase enviarAreaAtuacaoUseCase) {
        this.enviarAreaAtuacaoUseCase = enviarAreaAtuacaoUseCase;
    }

    @PostMapping
    public ResponseEntity<String> enviarAreaAtuacao(@RequestBody AreaAtuacaoRequestDTO dto) {
        return ResponseEntity.ok(enviarAreaAtuacaoUseCase.enviar(dto));
    }

    @GetMapping("/ping")
    public String ping() { return "ok"; }
}
