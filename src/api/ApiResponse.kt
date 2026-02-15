package api

import javax.xml.crypto.Data

sealed class ApiResponse<T> {
    data class Success<T>(val data: T, val message: String? = null) : ApiResponse<T>()
    data class Error(val message: String,val code: Int,val exception: Exception?=null): ApiResponse<Nothing>()
    object Loading: ApiResponse<Nothing>()
}