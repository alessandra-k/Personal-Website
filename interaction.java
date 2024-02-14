/** Student name: Alessandra Prunzel Kittlaus
 * File name: JavaScript for Assignment 1
 * Date: 06/11/2023
 * Section: CST8285_331
 * Brief Description: This JavaScript code adds interactive navigation to projects.html webpage that displays multiple *projects. Users can cycle through project descriptions using 'Previous' and 'Next' buttons, with only one project and *description visible at a time. 
 * It also seamlessly loops from the last project to the first.
*/


//selects all elements with the class name "project" and stores them in the "project" variable
const project = document.querySelectorAll('.project'); 
//selects all elements with the class name "descriptionBox" and stores them in the "descriptions" variable
const descriptions = document.querySelectorAll('.descriptionBox');

// Initialize the variable to track the currently displayed project, starting with the first project (index 0).
let currentProject = 0; 

/** Function responsible for displaying a specific project based on the provided Index.
  * "projectIndex" Parameter is the index of the project to display 
  *  within the array-like collection (elements) of projects.*/
function showProject(projectIndex) {

    // Check if projectIndex is less than 0 (going back from the first project)
    if (projectIndex < 0) {
        currentProject = project.length - 1; // Set currentProject to the last project
    } 

     /** Check if projectIndex is greater than or equal to the 
      * total number of projects (going forward from the last project) */
    else if (projectIndex >= project.length) {
        currentProject = 0; // Set currentProject to the first project
    }


    /** "forEach " javaScript array method that loops through each element in 
     * the "projects" and "descriptions" array-like collection and ensure that 
     * only the current project and its description are displayed, hiding all 
     * the other projects and descriptions*/
    project.forEach((proj) => (proj.style.display = 'none')); 
    descriptions.forEach((desc) => (desc.style.display = 'none'));


     // Display the selected project based on currentProject
    project[currentProject].style.display = 'block';
    // Display the description of the selected project based on currentProject
    descriptions[currentProject].style.display = 'block';
}

/** Determines which project slide to display. Called when the script loads, 
  * initializing with the first project, as the currentProject is set to 0.
  */
showProject(currentProject);

/** When the "Previous" button is clicked, showProject is called 
 *  with the currentProject decremented by 1. */
document.getElementById('prevButton').addEventListener('click', () => {
    currentProject--;
    showProject(currentProject);
});


/** When the "Next" button is clicked, showProject is called 
 *  with the currentProject incremented by 1. */
document.getElementById('nextButton').addEventListener('click', () => {
    currentProject++;
    showProject(currentProject);
});

