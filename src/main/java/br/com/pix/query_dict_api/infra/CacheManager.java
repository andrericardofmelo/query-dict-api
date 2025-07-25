package br.com.pix.query_dict_api.infra;

import br.com.pix.query_dict_api.domain.entries.Entries;
import br.com.pix.query_dict_api.exception.RepositoryExcection;
import br.com.pix.query_dict_api.repo.EntriesRepository;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Configuration
public class CacheManager {
    private final EntriesRepository entriesRepository;
    private final LoadingCache<String, Entries> entryCache;

    public CacheManager(EntriesRepository repository) {
        this.entriesRepository = repository;
        this.entryCache = CacheBuilder.newBuilder()
                .maximumSize(500)
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .recordStats()
                .build(new CacheLoader<>() {
                    @Override
                    public Entries load(String key) {
                        return entriesRepository.findEntryByKey(key);
                    }
                });
    }

    public Entries findEntry(String key) {
        try {
            return entryCache.get(key);
        } catch (ExecutionException e) {
            throw new RepositoryExcection("Error trying to retrieve the entry from the cache or repository");
        }
    }

    public void invalidateCacheEntry(String key) {
        entryCache.invalidate(key);
    }
}
