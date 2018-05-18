package io.github.maxcruz.repository.injectors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.maxcruz.domain.repository.Repository;
import io.github.maxcruz.repository.CurrencyRepository;
import io.github.maxcruz.repository.local.ConversionRateDao;
import io.github.maxcruz.repository.remote.CurrencyService;

/**
 * Dependency injection for the repository
 */
@Module
public class RepositoryModule {

    @Provides
    @Singleton
    Repository providesCurrencyData(ConversionRateDao conversionRateDao,
                                    CurrencyService currencyService) {
        return new CurrencyRepository(conversionRateDao, currencyService);
    }
}
