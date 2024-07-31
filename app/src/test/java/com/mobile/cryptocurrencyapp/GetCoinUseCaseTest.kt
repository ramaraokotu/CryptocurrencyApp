package com.mobile.cryptocurrencyapp

import com.mobile.cryptocurrencyapp.common.Resource
import com.mobile.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.mobile.cryptocurrencyapp.data.remote.dto.Links
import com.mobile.cryptocurrencyapp.data.remote.dto.LinksExtended
import com.mobile.cryptocurrencyapp.data.remote.dto.Stats
import com.mobile.cryptocurrencyapp.data.remote.dto.Tag
import com.mobile.cryptocurrencyapp.data.remote.dto.TeamMember
import com.mobile.cryptocurrencyapp.data.remote.dto.Whitepaper
import com.mobile.cryptocurrencyapp.domain.model.CoinDetail
import com.mobile.cryptocurrencyapp.domain.repository.CoinRepository
import com.mobile.cryptocurrencyapp.domain.use_case.get_coin.GetCoinUseCase
import junit.framework.Assert.assertTrue
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetCoinUseCaseTest {

    @Mock
    private lateinit var repository: CoinRepository

    private lateinit var getCoinUseCase: GetCoinUseCase

    @Before
    fun setUp() {
        getCoinUseCase = GetCoinUseCase(repository)
    }

    @Test
    fun `invoke returns coin detail on success`() = runBlocking {
        // Arrange
        val dummyTeamMembersDto = listOf(
            TeamMember(id = "1", name = "John Doe", position = "Developer"),
            TeamMember(id = "2", name = "Jane Smith", position = "Project Manager")
        )

        val dummyTagsDto = listOf(
            Tag(coin_counter = 1, ico_counter = 1, id = "cryptocurrency", name = "Cryptocurrency"),
            Tag(coin_counter = 2, ico_counter = 2, id = "decentralized", name = "Decentralized")
        )

        val dummyLinks = Links(
            explorer = listOf("https://explorer.example.com"),
            facebook = listOf("https://facebook.com/example"),
            reddit = listOf("https://reddit.com/r/example"),
            source_code = listOf("https://github.com/example"),
            website = listOf("https://example.com"),
            youtube = listOf("https://youtube.com/example")
        )


        val dummyWhitepaper = Whitepaper(
            link = "https://example.com/whitepaper",
            thumbnail = "https://example.com/thumbnail"
        )

        val dummyStats = Stats(
            contributors = 10,
            followers = 1000,
            stars = 500,
            subscribers = 200
        )

        val dummyLinksExtended = listOf(
            LinksExtended(
                stats = dummyStats,
                url = "https://example.com/extended",
                type = "website"
            )
        )

        val expectedCoinDetailDto = CoinDetailDto(
            description = "A decentralized digital currency",
            development_status = "Active",
            first_data_at = "2013-01-01",
            hardware_wallet = true,
            hash_algorithm = "SHA-256",
            id = "bitcoin",
            is_active = true,
            is_new = false,
            last_data_at = "2024-07-31",
            links = dummyLinks,
            links_extended = dummyLinksExtended,
            logo = "https://example.com/logo.png",
            message = "No messages",
            name = "Bitcoin",
            open_source = true,
            org_structure = "Decentralized",
            proof_type = "Proof of Work",
            rank = 1,
            started_at = "2009-01-03",
            symbol = "BTC",
            tags = dummyTagsDto,
            team = dummyTeamMembersDto,
            type = "Cryptocurrency",
            whitepaper = dummyWhitepaper,
        )

        val expectedCoinDetail = CoinDetail(
            coinId = "bitcoin",
            name = "Bitcoin",
            description = "A decentralized digital currency",
            symbol = "BTC",
            rank = 1,
            is_active = true,
            tags = listOf("Cryptocurrency", "Decentralized"),
            team = dummyTeamMembersDto,
        )

        // Configure mock behavior
        whenever(repository.getCoinById("bitcoin")).thenReturn(expectedCoinDetailDto)

        // Act
        val result = getCoinUseCase("bitcoin")

        // Assert
        assertTrue(result is Resource.Success)
        assertEquals(expectedCoinDetail, (result as Resource.Success).data)
    }
}
