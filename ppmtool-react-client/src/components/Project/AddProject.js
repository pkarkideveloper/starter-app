import React, { Component } from 'react'

 class AddProject extends Component {
     constructor(){
         super();
         this.state ={
             "projectName":"react project",
              "projectIdentifier":"ReactJs",
              "description":"desc",
              "startDate":"2021-03-01",
              "targetDate":"2021-07-23"
         }
     }
    render() {
        return (
            <div className="project">
        <div className="container">
            <div className="row">
                <div className="col-md-8 m-auto">
                    <h5 className="display-4 text-center">Create / Edit Project form</h5>
                    <hr />
                    <form>
                        <div className="form-group">
                            <input type="text" className="form-control form-control-lg " placeholder="Project Name"  name = "projectName"/>
                        </div>
                        <div className="form-group">
                            <input type="text" className="form-control form-control-lg" placeholder="Unique Project ID"
                            name = "projectIdentifier"
                                 />
                        </div>
                       {
                           // <!-- disabled for Edit Only!! remove "disabled" for the Create operation -->
                       }
                        <div className="form-group">
                            <textarea className="form-control form-control-lg" placeholder="Project Description" name ="description"></textarea>
                        </div>
                        <h6>Start Date</h6>
                        <div className="form-group">
                            <input type="date" className="form-control form-control-lg" name="startDate" />
                        </div>
                        <h6>Estimated End Date</h6>
                        <div className="form-group">
                            <input type="date" className="form-control form-control-lg" name="targetDate" />
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
