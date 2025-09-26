package com.engenharia_softeare.gerador_curriculo.llms.infra.controllers.dto.request;

import com.engenharia_softeare.gerador_curriculo.llms.infra.controllers.dto.response.RespostaPerguntasResponseDTO;
import java.util.List;

public record GerarCurriculoRequestDTO(
        List<RespostaPerguntasResponseDTO> perguntasRespostas,
        String areaAtuacao,
        String nome,
        String email,
        String celular,
        String cidade,
        List<String> links,
        String contexto) {
}
