package net.modi.journalApp.repository;

import net.modi.journalApp.entity.JournalEntry;
import net.modi.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {

}
