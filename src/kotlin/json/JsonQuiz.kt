package io.github.potatocurry.kashoot.json

import com.beust.klaxon.*

private val klaxon = Klaxon()

internal data class JSONQuiz (
    val uuid: String,
    val language: String,
    val creator: String,

    @Json(name = "creator_username")
    val creatorUsername: String,

    @Json(name = "creator_primary_usage")
    val creatorPrimaryUsage: String,

    @Json(name = "folderId")
    val folderID: String,

    val visibility: Int,
    val audience: String,
    val title: String,
    val description: String,
    val quizType: String,
    val cover: String,
    val coverMetadata: JsonMetadata,
    val questions: List<JsonQuestion>,
    val metadata: JsonMetadataClass,
    val resources: String,
    val slug: String,
    val type: String,
    val created: Long,
    val modified: Long
) {
    companion object {
        fun fromJson(json: String) = klaxon.parse<JSONQuiz>(json)
    }
}

internal data class JsonMetadata (
    val id: String
)

internal data class JsonMetadataClass (
    val resolution: String,
    val moderation: JsonModeration,
    val sponsored: Boolean,
    val duplicationProtection: Boolean,
    val lastEdit: JsonLastEdit
)

internal data class JsonLastEdit (
    @Json(name = "editorUserId")
    val editorUserID: String,

    val editorUsername: String,
    val editTimestamp: Long
)

internal data class JsonModeration (
    val flaggedTimestamp: Long,
    val timestampResolution: Long,
    val resolution: String
)

internal data class JsonQuestion (
    val type: String,
    val question: String,
    val questionFormat: Int,
    val time: Int,
    val points: Boolean,
    val numberOfAnswers: Int,
    val choices: List<JsonChoice>,
    val image: String,
    val imageMetadata: JsonMetadata,
    val resources: String
//    val video: JsonVideo
)

internal data class JsonChoice (
    val answer: String,
    val correct: Boolean
)

// Causes errors, probably because some parameters are empty
//internal data class JsonVideo (
//    val id: String = "",
//    val startTime: Long,
//    val endTime: Long,
//    val service: String,
//
//    @Json(name = "fullUrl")
//    val fullURL: String = ""
//)
