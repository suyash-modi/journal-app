package net.modi.journalApp.cache;

import jakarta.annotation.PostConstruct;
import net.modi.journalApp.entity.ConfigJournalAppEntity;
import net.modi.journalApp.repository.ConfigJournalAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    public enum keys{
        WEATHER_API;
    }
    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    public Map<String,String> API_CACHE=new HashMap<>();

    @PostConstruct
    public void init()
    {
        List<ConfigJournalAppEntity> all = configJournalAppRepository.findAll();
        for(ConfigJournalAppEntity configJournalAppRepository1:all)
        {
            API_CACHE.put(configJournalAppRepository1.getKey(), configJournalAppRepository1.getValue());
        }
    }
}
