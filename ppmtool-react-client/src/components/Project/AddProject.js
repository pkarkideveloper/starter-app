import React, { Component } from 'react'

 class AddProject extends Component {
     constructor(){
         super();
         this.state ={
             projectName:"",
              projectIdentifier:"",
              description:"",
              startDate:"",
              targetDate:""
         }; 
         this.onChange = this.onChange.bind(this);
         this.onSubmit = this.onSubmit(this);
     }
     onChange(e){
         this.setState({[e.target.name]:e.target.value});
     }

     onSubmit(e){
       
         const newProject =  {
            projectName: this.projectName,
             projectIdentifier:this.projectIdentifier,
             description:this.description,
             startDate:this.startDate,
             targetDate:this.targetDate
        };
        console.log(newProject);
     }
    render() {
        return (
            <div className="project">
        <div className="container">
            <div className="row">
                <div className="col-md-8 m-auto">
                    <h5 className="display-4 text-center">Create / Edit Project form</h5>
                    <hr />
                    <form onSubmit ={this.onSubmit}>
                        <div className="form-group">
                            <input type="text" className="form-control form-control-lg " placeholder="Project Name"  
                            name = "projectName"
                            value = {this.state.projectName}
                            onChange ={this.onChange.bind(this)}/>
                        </div>
                        <div className="form-group">
                            <input type="text" className="form-control form-control-lg" placeholder="Unique Project ID"
                            name = "projectIdentifier"
                            value = {this.state.projectIdentifier}
                            onChange ={this.onChange.bind(this)}

                                 />
                        </div>
                       {
                           // <!-- disabled for Edit Only!! remove "disabled" for the Create operation -->
                       }
                        <div className="form-group">
                            <textarea className="form-control form-control-lg" placeholder="Project Description"
                             name ="description"
                             value = {this.state.description}
                             onChange ={this.onChange.bind(this)}></textarea>
                        </div>
                        <h6>Start Date</h6>
                        <div className="form-group">
                            <input type="date" className="form-control form-control-lg" 
                            name="startDate"
                            value = {this.state.startDate} 
                            onChange ={this.onChange.bind(this)}/>

                        </div>
                        <h6>Estimated End Date</h6>
                        <div className="form-group">
                            <input type="date" className="form-control form-control-lg" name="targetDate"
                            value = {this.state.targetDate} 
                            onChange ={this.onChange.bind(this)}/>

                        </div>

                        <input type="submit" className="btn btn-primary btn-block mt-4" />
                    </form>
                </div>
            </div>
        </div>
    </div>
        );
    }
}
export default AddProject;
