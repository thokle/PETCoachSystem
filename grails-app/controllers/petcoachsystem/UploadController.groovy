package petcoachsystem

class UploadController {

    
    
    def index() { }
    
    
    
    def uploadFile(){
        def file = request.getFile('filename')
        
        
        file.transferTo()
        
    }
}
