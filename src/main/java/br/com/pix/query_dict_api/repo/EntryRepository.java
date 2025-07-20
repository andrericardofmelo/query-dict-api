package br.com.pix.query_dict_api.repo;

import br.com.pix.query_dict_api.domain.dto.AccountRequest;
import br.com.pix.query_dict_api.domain.dto.GetEntryResponse;
import br.com.pix.query_dict_api.domain.entries.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends MongoRepository<Entry, String> {

    GetEntryResponse getEntryByKey(String key) throws Exception;

    List<GetEntryResponse> getEntriesByAccount(AccountRequest accountRequest) throws Exception;

}
