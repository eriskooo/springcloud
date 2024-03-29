package sk.lorman.springboot.limitservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.lorman.springboot.limitservice.controller.dto.LimitConfigurationDTO;
import sk.lorman.springboot.limitservice.model.ConfigurationProperty;

@RestController
public class LimitsConfigurationController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ConfigurationProperty configurationProperty;

    public LimitsConfigurationController(ConfigurationProperty configurationProperty) {
        this.configurationProperty = configurationProperty;
    }

    @GetMapping("/limits")
    public LimitConfigurationDTO retrieveLimitsFromConfigurations() {
        LimitConfigurationDTO limitConfigurationDTO = new LimitConfigurationDTO(configurationProperty.getMinimum(),
                configurationProperty.getMaximum());

        logger.info("{}", limitConfigurationDTO);

        return limitConfigurationDTO;
    }
}
