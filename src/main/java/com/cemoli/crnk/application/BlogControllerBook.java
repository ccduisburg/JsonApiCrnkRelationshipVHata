package com.cemoli.crnk.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.crnk.core.engine.registry.RegistryEntry;
import io.crnk.core.engine.registry.ResourceRegistry;
import io.crnk.spring.boot.v3.CrnkConfigV3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
@Import({CrnkConfigV3.class})
public class BlogControllerBook {

    @Autowired
    private ResourceRegistry resourceRegistry;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("/resources-info")
    public Map<String, String> getResources() {
        Map<String, String> result = new HashMap<>();
        // Add all resources
        for (RegistryEntry entry : resourceRegistry.getResources()) {
            result.put(entry.getResourceInformation().getResourceType(),
                    resourceRegistry.getResourceUrl(entry.getResourceInformation()));
        }
        return result;
    }

    @PostConstruct
    public void configureJackson() {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
}

