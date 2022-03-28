package com.example.parsejsonfileapp

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
class TypeAhead(
    val queries: List<TypeAheadSuggestion?>?,
    val navigationModules: List<TypeAheadFacet?>?
)

@JsonClass(generateAdapter = true)
class TypeAheadSuggestion(
    val type: String?,
    val displayName: String?,
    val description: String?,
    val imageUrl: String?,
    val url: String?,
    val metaData: TypeAheadMetaData?
)

@JsonClass(generateAdapter = true)
class TypeAheadMetaData(
    val deptId: String?,
    val deptName: String?,
    val playStoreLink: String?,
    val appId: String?
)

@JsonClass(generateAdapter = true)
class TypeAheadFacet(
    val type: String?,
    val displayName: String?,
    val facetName: String?,
    val values: List<TypeAheadFacet?>?
)

@JsonClass(generateAdapter = true)
class TypeAheadFacetValue(
    val displayName: String?,
    val url: String?,
    val image: String?
)
