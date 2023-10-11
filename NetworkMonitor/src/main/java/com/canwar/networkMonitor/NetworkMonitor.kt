package com.canwar.networkMonitor

import kotlinx.coroutines.flow.Flow

/**
 * Utility for reporting app connectivity status
 */
interface NetworkMonitor {
    /**
     * The network monitor will continue to be updated using the data stream. Add delay to the data stream if necessary.
     */
    val isOnline: Flow<Boolean>
}