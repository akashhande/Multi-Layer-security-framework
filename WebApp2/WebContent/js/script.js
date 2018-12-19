/*
 * This is UI Process component of the cloud application
 */

function validateScript(value) {
    if (value.includes("DROP") || value.includes("DELETE") || value.includes("OR") || value.includes("NOT") || value.includes("WHERE") || value.includes("HAVING") ||
    		value.includes("drop") || value.includes("delete") || value.includes("or") || value.includes("not") || value.includes("where") || value.includes("having")) {
		alert("Please do not enter malicious keyword as input");
	}
}