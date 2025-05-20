package net.modi.journalApp.service;

import net.modi.journalApp.entity.JournalEntry;
import net.modi.journalApp.entity.User;
import net.modi.journalApp.repository.JournalEntryRepository;
import net.modi.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;



    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName) {
     try {
         User user = userService.findByUserName(userName);
         journalEntry.setDate(LocalDateTime.now());
         JournalEntry saved = journalEntryRepository.save(journalEntry);
         user.getJournalEntries().add(saved);
         userService.saveUser(user);
     }
     catch(Exception e)
     {
         System.out.println(e);
         throw new RuntimeException("An error occur while saving entry: ", e);
     }
    }

    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> getEntryById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }


    @Transactional
    public boolean deleteEntryById(ObjectId id,String userName) {
        boolean removed;
        try{
            User user = userService.findByUserName(userName);
             removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if (removed) {
                userService.saveUser(user);
                journalEntryRepository.deleteById(id);

            }

        }
        catch (Exception e)
        {
            System.out.println(e);
            throw new RuntimeException("An error occured while deleting entry", e);
        }
        return removed;
    }
}
