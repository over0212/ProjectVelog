edit('#### junil\n## hello\n![] localhost:8080/aa/a.jpg');

function edit(data){
    let cmdIndex = data.indexOf(' ');
    let cmd = data.substring(0, cmdIndex);
    let dataIndex = data.indexOf('\n');
    let text = data.substring(cmdIndex+1, dataIndex);
    data = data.substring(dataIndex+1);
    if(data.length != 0){
        if(cmd == '#'){
            
        } else if(cmd == '##'){

        } else if(cmd == '###'){
            
        } else if(cmd == '####'){
            
        } else if(cmd == '![]'){

        } else if(cmd == '**'){
            
        }
    }else{
        return;
    }
    
    edit(data);
}