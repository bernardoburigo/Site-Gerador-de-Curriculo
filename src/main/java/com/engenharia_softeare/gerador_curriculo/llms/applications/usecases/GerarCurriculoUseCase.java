package com.engenharia_softeare.gerador_curriculo.llms.applications.usecases;

import com.engenharia_softeare.gerador_curriculo.llms.infra.controllers.dto.request.GerarCurriculoRequestDTO;
import com.engenharia_softeare.gerador_curriculo.shared.config.PromptShared;
import com.engenharia_softeare.gerador_curriculo.shared.constants.ConstantsUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

@Service
public class GerarCurriculoUseCase {

    private final PromptShared promptShared;
    private final ObjectMapper mapper;

    public GerarCurriculoUseCase(PromptShared promptShared, ObjectMapper mapper) {
        this.promptShared = promptShared;
        this.mapper = mapper;
    }

    public String gerar(GerarCurriculoRequestDTO dto) {
        String contexto = ConstantsUtils.promptGerarCurriculo(dto, mapper);

        ChatResponse response = promptShared.montarModel(contexto);

        return response.getResult().getOutput().getText();
    }
}
