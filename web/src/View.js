import React from 'react';

class View extends React.Component {
    state = {
        host: []
    }

    componentDidMount() {
        const {REACT_APP_DIV_BK_COLOR} = process.env;
        const apiUrl = '/rest/app/info';
        console.log(apiUrl);
        fetch(apiUrl)
            .then((response) => response.json())
            .then((data) => {
                this.setState({ host: data })
                console.log(this.state.host)
            })
            .catch(console.log);
    }

    render() {
        const {host} = this.state;
        return (
            <div style={{color:process.env.REACT_APP_DIV_BK_COLOR}}>
                <h1>App Host</h1>
                <table>
                    <tr>
                        <td>LocalHostAddress</td>
                        <td>{host.localHostAddress}</td>
                    </tr>
                    <tr>
                        <td>localHostName</td>
                        <td>{host.localHostName}</td>
                    </tr>
                    <tr>
                        <td>remoteHostAddress</td>
                        <td>{host.remoteHostAddress}</td>
                    </tr>
                    <tr>
                        <td>remoteHostName</td>
                        <td>{host.remoteHostName}</td>
                    </tr>
                </table>
            </div>
        );
    }
}
export default View;
