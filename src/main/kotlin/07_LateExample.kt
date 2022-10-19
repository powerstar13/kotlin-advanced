class `07_LateExample` {

    @Autowired
    lateinit var service: TestService

    lateinit var subject: TestTarget

    @SetUp
    fun setup() {
        subject = TestTarget()
    }

    @Test
    fun test() {
        subject.doSomething()
    }
}