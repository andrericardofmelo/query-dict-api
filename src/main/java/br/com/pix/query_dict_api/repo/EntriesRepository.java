package br.com.pix.query_dict_api.repo;

import br.com.pix.query_dict_api.domain.dto.AccountRequest;
import br.com.pix.query_dict_api.domain.entries.Entries;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntriesRepository extends MongoRepository<Entries, String> {


    @Query("{ 'entry.key' : ?0 }")
    Entries findEntryByKey(String key);

    @Query("{ 'Entry.Account' : ?0 }")
    List<Entries> getEntriesByAccount(AccountRequest accountRequest);

}
