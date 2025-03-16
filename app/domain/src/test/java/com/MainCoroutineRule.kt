//package com
//
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.test.StandardTestDispatcher
//import kotlinx.coroutines.test.TestDispatcher
//import kotlinx.coroutines.test.TestScope
//import kotlinx.coroutines.test.resetMain
//import kotlinx.coroutines.test.setMain
//import org.junit.rules.TestWatcher
//import org.junit.runner.Description
//
//@ExperimentalCoroutinesApi
//class MainCoroutineRule(
//    val testDispatcher: TestDispatcher = StandardTestDispatcher()
//    ) : TestWatcher() {
//
//    val TestScope = TestScope(testDispatcher)
//
//    override fun starting(description: Description?) {
//        super.starting(description)
//        Dispatchers.setMain(testDispatcher) // this overrides Dispatchers.main
//    }
//
//    override fun finished(description: Description?) {
//        super.finished(description)
//        Dispatchers.resetMain() // after a test if finished, this resets dispatchers.main
//    }
//}
