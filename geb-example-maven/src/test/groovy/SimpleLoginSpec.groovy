import geb.spock.GebSpec
import spock.lang.*

class SimpleLoginSpec extends GebSpec {
    def "login with valid username and password"(){
        when:
        go "file:///home/mrtit/GitHub/Geb/geb-example-maven/login.html"
        waitFor(5) {
            $("#login-form input[name=username]").value("thanhmx")
			$("#login-form input[name=password]").value("insight")
			$("#login-form input[type=submit]").click()
		}
		
        then:
        println "finish"
    }

    def "login with invalid username and password"(){
        when:
        go "file:///home/mrtit/GitHub/Geb/geb-example-maven/login.html"

        then:
        $(".page-header").text() == "Login"

        when:
        $("#login-form input[name=username]").value("thanhmx")
        $("#login-form input[name=password]").value("badpassword")
        $("#login-form input[type=submit]").click()
        
        then:
        println "finish"
    }
}
