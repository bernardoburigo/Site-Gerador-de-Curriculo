package com.engenharia_softeare.gerador_curriculo.shared.constants;

public class ConstantsUtils {

    private ConstantsUtils() {
        throw new RuntimeException();
    }

    public static String promptAreaAtuacao(String areaAtuacao) {
        return String.format("""
        Você é um assistente especialista em recrutamento e seleção.
        Com base na área de atuação informada pelo candidato: "%s",
        gere uma lista de exatamente 10 perguntas em formato JSON.

        Regras:
        - O JSON deve conter apenas um array chamado "perguntas".
        - Cada item do array deve ser uma string com a pergunta.
        - Não adicione explicações, apenas o JSON puro.
        - O JSON deve ser válido.

        Exemplo de saída (para área: "Desenvolvedor Front-End"):

        {
          "perguntas": [
            "Quais linguagens de programação front-end você domina?",
            "Qual framework JavaScript você utiliza com mais frequência?",
            "Você tem experiência com testes automatizados no front-end?",
            "Como você gerencia o versionamento de código?",
            "Já trabalhou com metodologias ágeis como Scrum ou Kanban?",
            "Você possui experiência com integração de APIs?",
            "Quais ferramentas você utiliza para otimizar performance no front-end?",
            "Você já trabalhou com design responsivo e acessibilidade?",
            "Quais ferramentas de build ou bundlers você já utilizou?",
            "Você tem experiência com TypeScript?"
          ]
        }
        """, areaAtuacao);
    }
}
