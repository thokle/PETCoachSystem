package petcoachsystem



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CoachController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Coach.list(params), model:[coachInstanceCount: Coach.count()]
    }

    def show(Coach coachInstance) {
        respond coachInstance
    }

    def create() {
        respond new Coach(params)
    }

    @Transactional
    def save(Coach coachInstance) {
        if (coachInstance == null) {
            notFound()
            return
        }

        if (coachInstance.hasErrors()) {
            respond coachInstance.errors, view:'create'
            return
        }

        coachInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'coachInstance.label', default: 'Coach'), coachInstance.id])
                redirect coachInstance
            }
            '*' { respond coachInstance, [status: CREATED] }
        }
    }

    def edit(Coach coachInstance) {
        respond coachInstance
    }

    @Transactional
    def update(Coach coachInstance) {
        if (coachInstance == null) {
            notFound()
            return
        }

        if (coachInstance.hasErrors()) {
            respond coachInstance.errors, view:'edit'
            return
        }

        coachInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Coach.label', default: 'Coach'), coachInstance.id])
                redirect coachInstance
            }
            '*'{ respond coachInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Coach coachInstance) {

        if (coachInstance == null) {
            notFound()
            return
        }

        coachInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Coach.label', default: 'Coach'), coachInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'coachInstance.label', default: 'Coach'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
