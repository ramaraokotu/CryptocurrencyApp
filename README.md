# CryptocurrencyApp

Welcome to CryptocurrencyApp, a CryptocurrencyApp application built with MVVM architecture with Clean Architecture and Jetpack Compose.

## Major Highlights

- **Jetpack Compose** for modern UI
- **MVVM architecture combined with Clean Architecture** ensures a clean and scalable codebase.
- **Kotlin**
- **Dagger Hilt** for efficient dependency injection.
- **Retrofit** for seamless networking
- **Coroutines** for asynchronous programming
- **Unit tests** for robust code coverage
- **Navigation** for smooth transitions between screens

## Features Implemented

- Show Cryptocurrency coins list
- If we click the coin to show the coin details 

## Dependency Use

- Jetpack Compose for UI: Modern UI toolkit for building native Android UIs
- Retrofit for Networking: A type-safe HTTP client for smooth network requests
- Dagger Hilt for Dependency Injection: Simplifies dependency injection
- Mockito, JUnit for Testing: Ensures the reliability of the application

## How to Run the Project

- Clone the Repository:
```
git clone https://github.com/ramaraokotu/CryptocurrencyApp
cd CryptocurrencyApp
```
- Build and run the CryptocurrencyApp.

## The Complete Project Folder Structure

```
|── CoinApplication.kt
├── common
│   ├── Constants.kt
│   ├── Resource.kt
│  
├── data
│   ├── remote
│   │   ├── CoinParikaApi.kt
│   │   ├── dto
│   │   │   ├── CoinDetailDto.kt
│   │   │   └── CoinDto.kt
│   │   │   ├── Links.kt
│   │   │   └── LinksExtended.kt
│   │   │   ├── Stats.kt
│   │   │   └── Tag.kt
│   │   │   ├── TeamMember.kt
│   │   │   └── WhitePaper.kt
│   └── repository
│       └── CoinRepositoryImpl.kt
├── di
│   ├── AppModule
│   │   
├── domain
│   ├── model
│   │   ├── Coin.kt
│   │   ├── CoinDetail.kt
│   ├── repository
│   │   ├── CoinRepository.kt
│   ├── use_case
│   │   ├── get_coin.kt
│   │   │      └── GetCoinUseCase.kt
│   │   ├── get_coins.kt
│   │   │      └── GetCoinsUseCase.kt
│   │   │   
├── presentation
│   ├── coin_detail
│   │   ├── components
│   │   │      └── CoinDetailScreen.kt
│   │   │      └── CoinTag.kt
│   │   │      └── TeamListItem.kt
│   │   │   
│   │   ├── CoinDetailState.kt
│   │   ├── CoinDetailViewModel.kt
│   │   │   
│   ├── coin_list
│   │   ├── components
│   │   │      └── CoinListItem.kt
│   │   │      └── CoinListScreen.kt
│   │   │   
│   │   ├── CoinListState.kt
│   │   ├── CoinListViewModel.kt
│   ├── ui.theme
│   │   │      └── Color.kt
│   │   │      └── Theme.kt
│   │   │      └── Type.kt
│   ├── MainActivity
│   ├── Screen    
```

<p align="center">
  <img alt="screenshot1" src="https://github.com/ramaraokotu/CryptocurrencyApp/blob/main/app/src/main/assets/cryptocurrency_coins_list.png?raw=true" width="300">
  <img alt="screenshot2" src="https://github.com/ramaraokotu/CryptocurrencyApp/blob/main/app/src/main/assets/cryptocurrency_coin_detail.png?raw=true" width="300">
</p>


