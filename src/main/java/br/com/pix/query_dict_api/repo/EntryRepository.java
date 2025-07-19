package br.com.pix.query_dict_api.repo;

import br.com.pix.query_dict_api.domain.Entry;
import br.com.pix.query_dict_api.domain.dto.AccountRequest;
import br.com.pix.query_dict_api.domain.dto.GetEntryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<Entry, String> {

    GetEntryResponse getEntryByKey(String key) throws Exception;

    List<GetEntryResponse> getEntriesByAccount(AccountRequest accountRequest) throws Exception;

}
