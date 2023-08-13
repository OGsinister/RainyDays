package com.example.rainydays.feature_favorite.use_cases

data class FavoriteUseCases(
    val getFavoriteCitiesUseCase: GetFavoritesCitiesUseCase,
    val deleteFavoriteCityUseCase: DeleteFavoriteCityUseCase,
)