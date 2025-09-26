package com.engenharia_softeare.gerador_curriculo.shared.constants;

import com.engenharia_softeare.gerador_curriculo.llms.infra.controllers.dto.request.GerarCurriculoRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConstantsUtils {

    private ConstantsUtils() {
        throw new RuntimeException();
    }

    public static String promptAreaAtuacao(String areaAtuacao) {
        return String.format("""
                Voce e um assistente especialista em recrutamento e selecao.
                Com base na area de atuacao informada pelo candidato: \"%s\",
                gere uma lista de exatamente 10 perguntas em formato JSON.
                
                Regras:
                - O JSON deve conter apenas um array chamado \"perguntas\".
                - Cada item do array deve ser uma string com a pergunta.
                - Nao adicione explicacoes, apenas o JSON puro.
                - O JSON deve ser valido.
                
                Exemplo de saida (para area: \"Desenvolvedor Front-End\"):
                
                {
                  \"perguntas\": [
                    \"Quais linguagens de programacao front-end voce domina?\",
                    \"Qual framework JavaScript voce utiliza com mais frequencia?\",
                    \"Voce tem experiencia com testes automatizados no front-end?\",
                    \"Como voce gerencia o versionamento de codigo?\",
                    \"Ja trabalhou com metodologias ageis como Scrum ou Kanban?\",
                    \"Voce possui experiencia com integracao de APIs?\",
                    \"Quais ferramentas voce utiliza para otimizar performance no front-end?\",
                    \"Voce ja trabalhou com design responsivo e acessibilidade?\",
                    \"Quais ferramentas de build ou bundlers voce ja utilizou?\",
                    \"Voce tem experiencia com TypeScript?\"
                  ]
                }
                """, areaAtuacao);
    }

    public static String promptGerarCurriculo(GerarCurriculoRequestDTO dto, ObjectMapper mapper) {
        try {
            String contextoJson = mapper.writeValueAsString(dto);
            return String.format("""
                    Você é um assistente de RH especializado em redigir currículos profissionais em português (pt-BR).
                    
                    DADOS DO CANDIDATO (em JSON):
                    %s
                    
                    OBJETIVO
                    - Gerar um currículo **conciso, coerente e orientado à vaga** da área informada.
                    - Priorizar resultados, impactos e números quando aparecerem.
                    - Usar linguagem clara, profissional e compatível com ATS.
                    
                    ESTRUTURA
                    - Nome e dados de contato (se fornecidos).
                    - Resumo profissional.
                    - Competências (bullets).
                    - Experiências (cargo, empresa, período, 3–5 bullets de resultados).
                    - Formação, Certificações, Projetos, Idiomas (apenas se existirem).
                    - Omitir seções sem dados. Nunca inventar.
                    
                    ESTILO (MARKDOWN)
                    - Usar títulos (#, ##), listas com - e negrito em cargos/empresas.
                    - Texto pronto para edição em Markdown (sem blocos de código).
                    
                    SAÍDA
                    - Responda **somente** com JSON válido.
                    - O JSON deve ter apenas 1 chave: "curriculo".
                    - O valor de "curriculo" deve ser uma string Markdown.
                    - Use \\n para quebras de linha.
                    
                    EXEMPLO
                    {
                      "curriculo": "# Fulano da Silva\\n\\n**Desenvolvedor Front-End**\\n\\n## Resumo profissional\\nProfissional com ..."
                    }
                    """, contextoJson);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao serializar contexto", e);
        }
    }
}
