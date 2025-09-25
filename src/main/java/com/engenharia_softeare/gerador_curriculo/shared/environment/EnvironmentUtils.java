package com.engenharia_softeare.gerador_curriculo.shared.environment;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentUtils {

    private static String API_KEY_OPEN_AI;
    private static String OLLMA_GPT_OS_MODEL;
    private static String API_KEY_OLLMA;

    @Value("${langchain4j.open-ai.chat-model.api-key}")
    private String apiKey;

    @Value("${spring-ia-ollama.chat.model}")
    private String modelOllama;

    @Value("${spring-ia-ollama.chat.api-key}")
    private String apiKeyOllama;

    @PostConstruct
    private void init() {
        API_KEY_OPEN_AI = apiKey;
        OLLMA_GPT_OS_MODEL = modelOllama;
        API_KEY_OLLMA = apiKeyOllama;
    }

    public static String getApiKeyOpenAi() {
        return API_KEY_OPEN_AI;
    }

    public static String modelOllamaGptOs() {
        return OLLMA_GPT_OS_MODEL;
    }

    public static String apiKeyOllama() {
        return API_KEY_OLLMA;
    }
}
