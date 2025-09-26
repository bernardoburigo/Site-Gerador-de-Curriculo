package com.engenharia_softeare.gerador_curriculo.llms.applications.usecases;

import com.engenharia_softeare.gerador_curriculo.llms.infra.controllers.dto.request.AreaAtuacaoRequestDTO;
import com.engenharia_softeare.gerador_curriculo.shared.config.PromptShared;
import com.engenharia_softeare.gerador_curriculo.shared.constants.ConstantsUtils;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

@Service
public class GerarPerguntasUseCase {

    private final PromptShared promptShared;

    public GerarPerguntasUseCase(PromptShared promptShared) {
        this.promptShared = promptShared;
    }

    public String gerar(AreaAtuacaoRequestDTO dto) {
        try {
            String contexto = ConstantsUtils.promptAreaAtuacao(dto.areaAtuacao());

            ChatResponse response = promptShared.montarModel(contexto);

            return response.getResult().getOutput().getText();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar: ", e);
        }
    }
}
